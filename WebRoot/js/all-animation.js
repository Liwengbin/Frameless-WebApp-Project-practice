$(function(){
		$('.layout-navigationuser-ulimg > img').on('click',function(){
		/* alert("me"); */
				$('.layout-navigationuser-div').toggleClass('open');
				$('.layout-navigationuser-div-span').toggleClass('openfont');
			});
		});
function ulout(x){
	$('.layout-navigationuser-ulimg').removeClass('openul');
}
function ulover(x){
	$('.layout-navigationuser-ulimg').addClass('openul');
}