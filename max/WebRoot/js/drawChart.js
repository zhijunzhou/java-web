/**
 * 
 */
$(function(){
		var data = [
		         	{
		         		name : '注册',
		         		value:[16,15,10,20],
		         		color:'#32bdbc'
		         	},
		         	{
		         		name : '未注册',
		         		value:[3,6,11,1],
		         		color:'#d75a5e'
		         	}
		         ];
        
		var chart = new iChart.ColumnStacked2D({
				render : 'canvasDiv',
				data: data,
				labels:["Jan","Feb","Mar","April"],
				title : {
					text:'Team take part in training comparision',
					color:'#dcd6cb',
					textAlign:'left',
					padding:'0 40',
					font:'微软雅黑',
					border:{
						enable:true,
						width:[0,0,4,0],
						color:'#698389'
					},
					height:40
				},
				footnote : {
					text:'Data from：http://localhost:3000/trainingDetail',
					font:'微软雅黑',
					padding:'0 8',
					color:'#dcd6cb'
				},
				padding:'8 0',
				width : 800,
				height : 400,
				column_width:70,
				gradient : true,//应用背景渐变
				gradient_mode:'LinearGradientDownUp',//渐变类型
				color_factor : 0.1,//渐变因子
				background_color : '#425154',
				animation : true,//开启过渡动画
				animation_duration:600,//600ms完成动画
				sub_option:{
					label:{color:'#f9f9f9',fontsize:12,fontweight:600},
					border : false
				},
				label:{color:'#dcd6cb',font:'微软雅黑',fontsize:12,fontweight:600},
				legend:{
					enable:true,
					background_color : null,
					line_height:25,
					color:'#dcd6cb',
					fontsize:12,
					font:'微软雅黑',
					fontweight:600,
					border : {
						enable : false
					}
				},
				tip:{
					enable:true,
					shadow:true,
					listeners:{
						 //tip:提示框对象、name:数据名称、value:数据值、text:当前文本、i:数据点的索引
						parseText:function(tip,name,value,text,i){
							console.log(tip);
							 return "<a href='#'><span style='color:#005268;font-size:12px;'>"+name + ": " + value+" 人</span></a>";
						}
					}
				},
				column_width:80,
				coordinate:{
					background_color : 0,
					grid_color:'#888888',
					axis : {
						color : '#c0d0e0',
						width : 0
					}, 
					scale:[{
						 position:'left',	
						 scale_enable : false,
						 start_scale:0,
						 scale_space:2,
						 end_scale:30,
						 label:{color:'#dcd6cb',fontsize:11,fontweight:600}
					}],
					width:'80%',
					height:'76%'
				}
		});

		//利用自定义组件构造左上侧单位
		chart.plugin(new iChart.Custom({
				drawFn:function(){
					//计算位置
					var coo = chart.getCoordinate(),
						x = coo.get('originx'),
						y = coo.get('originy');
					//在左上侧的位置，渲染一个单位的文字
					chart.target.textAlign('end')
					.textBaseline('bottom')
					.textFont('600 12px 微软雅黑')
					.fillText('单位(个)',x,y-14,false,'#be5863')
					
				}
		}));
		
		chart.draw();
	});