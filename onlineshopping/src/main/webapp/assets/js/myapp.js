$(function(){		
	switch(menu){		
		case 'About':
			$('#about').addClass('active');
			break;
		case 'Contact':
			$('#contact').addClass('active');
			break;
		case 'All Products':
			$('#listProducts').addClass('active');
			break;
		case 'Manage Products':
			$('#manageProducts').addClass('active');
			break;
		case 'Home':break;
		default: 
			$('#listProducts').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
	}
	
	//code for jquery data table
	var $table = $('#productListTable');
	//alert(window.contextRoot);
	if($table.length){		
		jsonUrl='';
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
		}		

		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Records', '5 Records', '10 Records','ALL']],
			pageLength: 5,
			ajax:{
				url: jsonUrl,
				dataSrc:''//??				
			},
			columns:[
			         	{
			         		data: 'code',
			         		mRender: function(data, type, row){
			         			return '<img src="' + window.contextRoot+'/resources/images/' + data +'.jpg" class="datatableImg"/>';
			         			
			         		}			         		
			         	},
			         	{
			         		data:'name'
			         	},
			         	{
			         		data:'brand'
			         	},
			         	{
			         		data:'unitPrice'		         			
			         	}
			         	,
			         	{
			         		data:'quantity',
			         		mRender: function(data, type, row){
			         			if(data < 1){
			         				return '<span style="color:red">Out of Stock</span>';
			         			}
			         			return data;
			         		}
			         	},
			         	{
			         		data:'id',
			         		bsortable: false,
			         		mRender:function(data, type, row){
			         			var str = '';
			         			
			         			str += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160&#160;';
			         		
			         			if(row.quantity < 1){
			         				str += '<a href="javascript.void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
			         			}else{
			         				str += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
			         			}        			
			         					         			
			         			return str;			         			
			         		}
			         	}
			         ]
		});
		
	}
	
	var $alert = $('.alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
		},3000)
	}
	
	
	$('.switch input[type="checkbox"]').on('change', function(){
		//alert("change!!");
		
		//get the check box
		var checkbox = $(this);
		
		//get the property "checked"
		var checked = checkbox.prop('checked');
		
		//if checked become true after the change event : false after change event 
		var dMsg = (checked) ? 'Do you want to activate the product' : 'Do you want to deactivate the product';
		
		//id of the product
		var value = checkbox.prop('value');
		
		//setup dialogue box detail
		bootbox.confirm({
			size: 'medium', 
			title: 'Product Activation & Deactivation',
			//if ok in clicked
			callback: function(confirmed){
				if(confirmed){
					console.log(value);
					bootbox.alert(
						{
							size: 'medium',
							tile: 'Information',
							message: 'You are going to perform operation on product.'						
						}
					);
				}
				//if ok is not clicked
				else{
					checkbox.prop('checked', !checked);
				}
			},
			message: dMsg			
		});
		
	});
	
});

