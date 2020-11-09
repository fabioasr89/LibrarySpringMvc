
	<div class="col-9" style="overflow-x:auto;">
		<table id="tableView" class="table table-borderless" style="background-color:white;">
			<thead style="background-color: cadetblue;color: white;font-weight:700;">
				<tr>
					<td>Titolo</td>
					<td>Pubbicazione</td>
					<td>Data Inserimento</td>
					<td>Copertina</td>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>

<script>
	$(document).ready(function(){
		var table=$('#tableView').DataTable({
			"language":{
				"emptyTable":"Non ci sono libri caricati attualmente in libreria"
			}
		});
		$.ajax({
			type:'POST',
			dataType:'json',
			url:'getAllLibri',
			success:function(xhr){
				if(xhr!=null){
					for(var i in xhr){
						var titolo=xhr[i].titolo;
						var pubblicazione=xhr[i].dataPubblicazione;
						var dataInserimento=xhr[i].dataInserimento;
						var img="<img src='data:image/png;base64,"+xhr[i].img+"' class='img-thumbnail'>"
						table.row.add([titolo,pubblicazione,dataInserimento,img]).draw(false);
					
					}
				}

				
			},error:function(){
				
				
			},complete:function(){
				
			}

			
		});
		
		
	});
</script>