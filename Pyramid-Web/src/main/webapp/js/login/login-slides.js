/**
 * 滑动页初始化
 */
$(function() {
			$('#slide_one').highcharts({
				title : {
					text : '准妈妈入院登记数据统计',
					x : -20
					// center
				},
				subtitle : {
					text : '按孕周分别进行全年统计',
					x : -20
				},
				xAxis : {
					categories : ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
							'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
				},
				yAxis : {
					title : {
						text : '人次'
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
					valueSuffix : '检查人次'
				},
				legend : {
					layout : 'vertical',
					align : 'right',
					verticalAlign : 'middle',
					borderWidth : 0
				},
				series : [{
					name : '小于14周',
                    ids:[11,12,13,14,15,16,17,18,19,20,21,22],
					data : [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3,
							18.3, 13.9, 9.6]
				}, {
					name : '14-28周',
                    ids:[111,112,113,114,115,116,117,118,119,210,211,212],
					data : [0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1,
							14.1, 8.6, 2.5]
				}, {
					name : '28-40周',
                    ids:[211,212,213,214,215,216,217,218,219,220,221,222],
					data : [0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3,
							9.0, 3.9, 1.0]
				}]
			});
			
			$('#slide_two').highcharts({
				title : {
					text : '准妈妈 - 第二个滑动块',
					x : -20
					// center
				},
				subtitle : {
					text : '按孕周分别进行全年统计',
					x : -20
				},
				xAxis : {
					categories : ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
							'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
				},
				yAxis : {
					title : {
						text : '人次'
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
					valueSuffix : '检查人次'
				},
				legend : {
					layout : 'vertical',
					align : 'right',
					verticalAlign : 'middle',
					borderWidth : 0
				},
				series : [{
					name : '小于14周',
                    ids:[11,12,13,14,15,16,17,18,19,20,21,22],
					data : [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3,
							18.3, 13.9, 9.6]
				}, {
					name : '14-28周',
                    ids:[111,112,113,114,115,116,117,118,119,210,211,212],
					data : [0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1,
							14.1, 8.6, 2.5]
				}, {
					name : '28-40周',
                    ids:[211,212,213,214,215,216,217,218,219,220,221,222],
					data : [0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3,
							9.0, 3.9, 1.0]
				}]
			});
			
			$('#slide_three').highcharts({
				title : {
					text : '准妈妈 - 第三个滑动块',
					x : -20
					// center
				},
				subtitle : {
					text : '按孕周分别进行全年统计',
					x : -20
				},
				xAxis : {
					categories : ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
							'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
				},
				yAxis : {
					title : {
						text : '人次'
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
					valueSuffix : '检查人次'
				},
				legend : {
					layout : 'vertical',
					align : 'right',
					verticalAlign : 'middle',
					borderWidth : 0
				},
				series : [{
					name : '小于14周',
                    ids:[11,12,13,14,15,16,17,18,19,20,21,22],
					data : [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3,
							18.3, 13.9, 9.6]
				}, {
					name : '14-28周',
                    ids:[111,112,113,114,115,116,117,118,119,210,211,212],
					data : [0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1,
							14.1, 8.6, 2.5]
				}, {
					name : '28-40周',
                    ids:[211,212,213,214,215,216,217,218,219,220,221,222],
					data : [0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3,
							9.0, 3.9, 1.0]
				}]
			});
			
		});