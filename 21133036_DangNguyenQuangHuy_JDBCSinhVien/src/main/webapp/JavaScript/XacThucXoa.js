function testConfirmDialog(id)
 {
 	var result=confirm("Bạn chắc chắc có muốn xoá không");
 	if(result==true)
 	{
 		window.location.href="XoaSV?id="+id;
 	}
 	else
 	{
 		return false;
 	}
 }