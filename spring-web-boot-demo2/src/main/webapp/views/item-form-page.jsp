<html>
	<head>
		<title>Item </title>
		<link rel="stylesheet" href="css/site.css">
	</head>
	<body>
		<jsp:include page="/header"/>
		<section>
			<h1>Item Form </h1>
		
		<form  method="POST">
			<div>
			<label>Icode</label>
				<input type="number" name="icode"/>
			</div>
		<div>
			<label>Item Name</label>
				<input type="text" name="name"/></div>
		<div>
			<label>Cost Price</label>
				<input type="decimal" name="costPrice"/></div>
		<div>
			
			<label>Category</label>
				<select name="category">
				<option value="AGRO">AGRO</option>
				<option value="ORNIMENT">ORNIMENT</option>
				<option value="DAIRY">DAIRY</option>
				<option value="CLOTHS">CLOTHS</option>
				<option value="OTHERS">OTHERS</option>
			</select>
		</div>
		
		<button>OK</button>
		</form>
	</section>
</body>
</html>