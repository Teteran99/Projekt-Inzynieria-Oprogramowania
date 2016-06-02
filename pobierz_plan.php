<?php
	
	require("simple_html_dom.php");
	
	$html = file_get_html("http://plan.uz.zgora.pl/grupy_lista_kierunkow.php");
	$wydzial = $html->find("body ul li");
	$nw = [];

	foreach($wydzial as $i => $wydz) {
		//	echo "text:".$wydz->innertext."/text";
			if (preg_match("/Wydział(.*)<ul>/", $wydz->innertext, $nazwawydz) == 1){
			//	print_r2($nazwawydz);
				$nazwaWydzialu = "Wydział " . trim($nazwawydz[1]);
				array_push($nw, $nazwaWydzialu);
			}
	}
	
	function poka_plan($url){
		$html = file_get_html($url);
		$l = 0;

		$wiersze = $html->find("table tr");

		foreach($wiersze as $j=> $wiersz){
				
			if ($wiersz != $wiersze[1] && $wiersz!=$wiersze[0]){
				if (substr_count($wiersz, "</td>")== 1){
					$nazwaDnia = $wiersz->find('b',0)->innertext;
					
					if (!isset($plan[$nazwaDnia])) 
						$plan[$nazwaDnia] = [];
				}
				
				else{
					for ($i = 0; $i < 8; $i++){
						if ($wiersz->find("td", $i)->find("a") == true)
							$lekcja[$i] = $wiersz->find("td", $i)->find("a", 0)->innertext;
						else
							$lekcja[$i] = $wiersz->find("td", $i)->innertext;
					}
					array_push($plan[$nazwaDnia], $lekcja);
				}
				
			}

		}
				//Wyswietla plan
		foreach($plan as $i => $elemTab){
			echo '<tr align="left"><td bgcolor="#404040"colspan="8"><font size="5">'.$i.'</font></td></tr>';
			
			foreach($elemTab as $j => $eT){
				if ($l % 2 != 0) echo '<tr bgcolor="#553579">'; // Zeby byly kolorki na zmiane
				else echo "<tr>";
				for ($k =0; $k < 8; $k++){
					echo "<td>".$eT[$k]."</td>";
				}
				echo "</tr>";
				$l++;
			}
		}
	}	

	function poka_wydzialy() {
		global $html;
		global $nw;
		$wydzialy = [];
		$uls = $html->find("ul", 0);
		$x = 0;

		foreach($uls->find("li") as $li) {
			preg_match("/Wydział(.*)<ul>/", $li->innertext, $wyniki);
			if(count($wyniki) > 1) {
				$nazwaWydzialu = "Wydział " . trim($wyniki[1]);
				$wydzialy[$nazwaWydzialu] = [];

				foreach($li->find("ul", 0)->find("li") as $second_li) {
					$a = $second_li->find("a", 0);
					if($a) {
						array_push($wydzialy[$nazwaWydzialu], [
							'nazwa' => $a->innertext,
							'link' => $a->href
						]);
					}
				}						
			}

		}
			//Wyswietla wydzialy
		foreach($wydzialy as $wydz){
			echo '<br><h2>'.$nw[$x]."</h2><br>";
			foreach($wydz as $l => $w){
				echo '<a href ="grupy.php?link=http://plan.uz.zgora.pl/'.$w['link'].'" class="kierunekLink">'.$w['nazwa']."</a><br>";	
			}
			$x++;
		} 

	}

	
	function poka_grupy($urlGrupy){
		$url = file_get_html($urlGrupy);
		$wiersze = $url->find("table", 1)->find("tr");
		$grupy = [];
		
		foreach($wiersze as $wiersz){
			$td = $wiersz->find("td", 0);
			$a = $td->find("a", 0);
			
			$pelnaNazwaGrupy = explode(" ", $a->innertext);
			$nazwaGrupy = $pelnaNazwaGrupy[0];
			
			if (!isset($grupy[$nazwaGrupy]))
				$grupy[$nazwaGrupy] = [];
			
			if ($a){
				$grupy[$nazwaGrupy]['nazwa'] = $a->innertext;
				$grupy[$nazwaGrupy]['link'] = $a->href;
			}
		}
		
		foreach($grupy as $gr){
			echo '<a href="plan_grupy.php?link=http://plan.uz.zgora.pl/'.$gr['link'].'" class = "kierunekLink">'.$gr['nazwa']."</a><br>";
		}
	}

	//poka_grupy("http://plan.uz.zgora.pl/grupy_lista_grup_kierunku.php?pId_kierunek=8203");
	//poka_wydzialy();

	
	function print_r2($val){
        echo '<pre>';
        print_r($val);
        echo  '</pre>';
}
?>