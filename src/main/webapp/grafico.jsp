<%-- 
    Document   : grafico
    Created on : 25/10/2023, 07:34:31 AM
    Author     : JosselynMartinez
--%>

<%@page import="java.util.List"%>
<%@page import="modelos.encuesta"%>
<%@page import="modelosDAO.EncuestaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
	<title>Pie Chart</title>
	<script src="chartjs/Chart.min.js"></script>
	<script src="chartjs/samples/utils.js"></script>
        <%@ include file="menu.jsp" %>
</head>

<body>
    
    <% 
     EncuestaDAO encuestadao = new EncuestaDAO();
     List<encuesta> consulta1 = encuestadao.grafico();
     String datos ="";
     String label="'";
        
        for(encuesta enc1 : consulta1 ){
           String sexo = enc1.getTipo();
            int count = enc1.getCantidad();
           datos+= count+",";
           label+=sexo+"','";
        }
      label+="'";
      label = label.substring(0, label.length() - 2);
    %>

        <br><br>
        <div class="container" align="center">
            <h3>Grafica</h3><br>
            <div id="canvas-holder" style="width:40%">
                <canvas id="chart-area"></canvas>
            </div>
        </div>
        
    
	<script>
            
		var randomScalingFactor = function() {
			return Math.round(Math.random() * 100);
		};

		var config = {
			type: 'pie',
			data: {
				datasets: [{
					data: [
                                                <%=datos%>
					],
					backgroundColor: [
                                                window.chartColors.red,
						window.chartColors.orange,
						window.chartColors.blue,
					],
					label: 'Sexo'
				}],
				labels: [
                                        <%=label%>
				]
			},
			options: {
				responsive: true
			}
		};

		window.onload = function() {
			var ctx = document.getElementById('chart-area').getContext('2d');
			window.myPie = new Chart(ctx, config);
		};

		document.getElementById('randomizeData').addEventListener('click', function() {
			config.data.datasets.forEach(function(dataset) {
				dataset.data = dataset.data.map(function() {
					return randomScalingFactor();
				});
			});

			window.myPie.update();
		});

		
	</script>
</body>
</html>
