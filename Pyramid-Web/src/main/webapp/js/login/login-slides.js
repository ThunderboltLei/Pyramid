/**
 * 滑动页初始化
 */
$(function() {
			$('#slide_one').highcharts({
				title : {
					text : 'Monthly Average Temperature',
					x : -20
					// center
				},
				subtitle : {
					text : 'Source: 第一个滑动页',
					x : -20
				},
				xAxis : {
					categories : ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
							'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
				},
				yAxis : {
					title : {
						text : 'Temperature (°C)'
					},
					plotLines : [{
								value : 0,
								width : 1,
								color : '#808080'
							}]
				},
				plotOptions : {
					line : {
						dataLabels : { // 节点是否显示数据
							enabled : false
						}
					},
					series : { // 节点点击事件
						cursor : 'pointer',
						events : {
							click : function(e) {
								alert(e.point.category+", " + e.point.data);
							}
						}
					}
				},
				tooltip : {
					valueSuffix : '°C'
				},
				legend : {
					layout : 'vertical',
					align : 'right',
					verticalAlign : 'middle',
					borderWidth : 0
				},
				series : [{
					name : 'Tokyo',
                    ids:[11,12,13,14,15,16,17,18,19,20,21,22],
					data : [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3,
							18.3, 13.9, 9.6]
				}, {
					name : 'New York',
                    ids:[111,112,113,114,115,116,117,118,119,210,211,212],
					data : [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1,
							14.1, 8.6, 2.5]
				}, {
					name : 'Berlin',
                    ids:[211,212,213,214,215,216,217,218,219,220,221,222],
					data : [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3,
							9.0, 3.9, 1.0]
				}, {
					name : 'London',
                    ids:[311,312,313,314,315,316,317,318,319,320,321,322],
					data : [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2,
							10.3, 6.6, 4.8]
				}]
			});
		});