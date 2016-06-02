<!DOCTYPE HTML>
<html lang="pl">
	<head>
	
	 <meta charset="utf-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	 <title>Projekt</title>
	 <link rel="stylesheet" href="style.css" type="text/css" />
	 
	</head>
	
  <body>

  <h1 align = "center"><a href="index.php" class = "planLink">Plan zajęć</a></h1>
	<table id=tabela width = 90% align="center">
	<?php
		require("pobierz_plan.php");
		poka_plan($_REQUEST['link']);
	?>
	</table>
  </body>
</html>