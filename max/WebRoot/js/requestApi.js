/**
 * call web service
 */
$(function() {
	
	// stop lesson
	$("#endlesson").on("click", function() {
		var lesson_arrangement_id = $("#lesson_arrangement_id").val();
		
		$("body").css("opacity","0.5");
		$.ajax({
			url:"lesson/stopLesson.do?lesson_arrangement_id="+lesson_arrangement_id,
			async:true,
			success:function(data) {
				if(data === 1) {
					alert("课程状态修改成功！");
					window.location.reload(true);
				} else if(data === 2) {
					alert("课程已修改，请勿重复修改！");
				} else if(data === 3) {
					alert("修改失败！");
				} 
				$("body").css("opacity","1");
				$("#joinLesson").css("disabled","disabled");
			},
			fail:function(data) {
				console.log(data);
			} 
		});
	});
	
	// start lesson
	$("#startlesson").on("click", function() {
		var lesson_arrangement_id = $("#lesson_arrangement_id").val();
		$("body").css("opacity","0.5");
		$.ajax({
			url:"lesson/startLesson.do?lesson_arrangement_id="+lesson_arrangement_id,
			async:true,
			success:function(data) {
				if(data === 1) {
					alert("课程状态修改成功！");
					window.location.reload(true);
				} else if(data === 2) {
					alert("课程已修改，请勿重复修改！");
				} else if(data === 3) {
					alert("修改失败！");
				} 
				$("body").css("opacity","1");
				$("#joinLesson").css("disabled","disabled");
			},
			fail:function(data) {
				console.log(data);
			} 
		});
		
	});
	
	// join a specific lesson
	$("#joinLesson").on("click", function() {
		var lesson_arrangement_id = $("#lesson_arrangement_id").val();
		$("body").css("opacity","0.5");
		$.ajax({
			url:"lesson/join.do?lesson_arrangement_id="+lesson_arrangement_id,
			async:true,
			success:function(data) {
				if(data === 0) {
					alert("加入成功");
				} else if(data === 1) {
					alert("加入失败");
				} else if(data === 2) {
					alert("还未登录");
				} else if(data === 3) {
					alert("请勿重复加入该课程");
				}
				$("body").css("opacity","1");
				$("#joinLesson").css("disabled","disabled");
			},
			fail:function(data) {
				console.log(data);
			}
		});
	});
	
	// send email
	$("#sendmail").on("click", function() {
		var lesson_arrangement_id = $("#lesson_arrangement_id").val();
		var maillist = [];
		$(".mailaddr").each(function() {
			if($(this).is(":checked") === true) {
				maillist.push($(this).val());
			}
		});	
		if(maillist.length > 0) {
			$.ajax({
				url:"lesson/sendmail.do?lesson_arrangement_id="+lesson_arrangement_id,
				async:true,
				data:{maillist:maillist.toString()},
				method:"POST",
				dataType:"json",
				success:function(data) {
					if(data === 0) {
						alert("发送成功");
					} else if(data === -1) {
						alert("请至少选择一个要接收的邮箱地址");
					} else {
						alert("发送失败");
					}
				},
				fail:function(data) {
					console.log(data);
				}
			});
		}
		
		
	});
	
});
