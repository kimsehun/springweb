/*** �Ѹ� ��� ***/

jQuery.fn.extend({

	
	/*** �Ϲ� �������� �Ѹ� ***/
	/*** �������� �ڵ��̵�
	     ȭ��ǥ�� ���� ��/���� �̵� ����
		 ���콺 �ø��� �ڵ��Ѹ� ����
		 ���콺 �ø��� li�� over class �߰�
		 ***/
	gallery_rolling:function(p_dispNumber, p_speed, p_dispTimeout)
	{
		return this.each(function(){
			var dispNumber  = p_dispNumber==null ? 1 : p_dispNumber;      // �������� ����
			var speed       = p_speed==null ? 700 : p_speed;              // �ѹ� �����̴� �ð�
			var dispTimeout = p_dispTimeout==null ? 4000 : p_dispTimeout; // �ѹ� ���� �ð�

			function gallery_moveTo(i)
			{
				current = i;
				$gallery_ul.animate({"left":-current*li_width}, {duration:speed, queue:false});
			}

			function gallery_prev(is_auto)
			{
				// ���콺 �÷��������� �ڵ��Ѹ� ����
				if(is_auto!=false && is_over)  return;

				var prev = 0 >= current ? li_count-1 : current-1;
				gallery_moveTo(prev);
			}

			function gallery_next(is_auto)
			{
				// ���콺 �÷��������� �ڵ��Ѹ� ����
				if(is_auto!=false && is_over)  return;

				var next = (li_count-dispNumber) <= current ? 0 : current+1;
				gallery_moveTo(next);
			}

			var current = 0; // ���� ǥ�õ� ��ġ
			var is_over = false; // ���콺 �÷����ִ��� ����

			var $gallery      = $(this);
			var $carrousel_box= $gallery.find("> div.carrousel_box");
			var $gallery_ul   = $carrousel_box.find(" > ul");
			var $gallery_li   = $gallery_ul.find(" > li").css({"float":"left"});

			var li_width = $gallery_li.eq(0).width();
			var li_height= $gallery_li.eq(0).height();
			var li_count = $gallery_li.size();

			// ��ʹڽ�
			$gallery.hover(function(){ is_over = true; }
						, function(){ is_over = false;});

			// ȭ��ǥ
			$gallery.find("> .arrow_prev").click(function(){ gallery_prev(false); }).end()
					.find("> .arrow_next").click(function(){ gallery_next(false); }).end();

			// CSS
			$carrousel_box.css({"position":"absolute", "width":li_width*dispNumber, "height":li_height, "overflow":"hidden"});
			$gallery_ul.css({"position":"absolute", "top":0, "left":0, "width":li_width * li_count, "height":li_height});
			$gallery_li.hover(function(){$(this).addClass("over")}, function(){$(this).removeClass("over")});

			// Play
			window.setInterval(gallery_next, dispTimeout);
		});
	}

	
	
	/*** �ٹ��� �Ѹ� ***/
	/*** ������� �̵�
	     ȭ��ǥ�� ���� ��/�� �̵� ����
		 ���콺 �ø��� �ڵ��Ѹ� ����
		 LI�� Ȱ��ȭ�Ǹ� div.main_img�� �̹��� ������
		 ***/
	, album_rolling:function(p_dispNumber, p_speed, p_dispTimeout)
	{
		return this.each(function(){
			var dispNumber  = p_dispNumber==null ? 3 : p_dispNumber;      // �������� ����
			var speed       = p_speed==null ? 400 : p_speed;              // �ѹ� �����̴� �ð�
			var dispTimeout = p_dispTimeout==null ? 3000 : p_dispTimeout; // �ѹ� ���� �ð�

			function album_moveTo(i)
			{
				current = i;
				if(i <= Math.floor(dispNumber/2))
					var album_pos = 0;
				else if((li_count-dispNumber) < i)
					var album_pos = li_count-dispNumber;
				else
					var album_pos = i - Math.floor(dispNumber/2);

				$album_ul
					.animate({"top":-album_pos*li_height}, {duration:speed, queue:false})
					.find("> li:eq("+i+")")
					.trigger("active");
			}

			function album_prev(is_auto)
			{
				if(is_play==false) return;

				// ���콺 �÷��������� �ڵ��Ѹ� ����
				if(is_auto!=false && is_over)  return;

				var prev = 0 >= current ? li_count-1 : current-1;
				album_moveTo(prev);
			}

			function album_next(is_auto)
			{
				if(is_play==false) return;

				// ���콺 �÷��������� �ڵ��Ѹ� ����
				if(is_auto!=false && is_over)  return;

				var next = (li_count-1) <= current ? 0 : current+1;
				album_moveTo(next);
			}

			var _timer	= null;
			var current	= 0; // ���� ǥ�õ� ��ġ
			var is_play	= false; // �Ѹ� ����
			var is_over	= false; // ���콺 �÷����ִ��� ����

			var $album		= $(this);
			var $main_img	= $album.find("div.main_img");
			var $carrousel_box= $album.find("> div.carrousel_box");
			var $album_ul	= $carrousel_box.find(" > ul");

			var li_width = $album_ul.find("> li:eq(0)").width();
			var li_height= $album_ul.find("> li:eq(0)").height();
			var li_count = $album_ul.find("> li").size();

			// ��ʹڽ�
			$album
				.bind("play", function(){
					is_play = true;
					album_moveTo(0);
					if(_timer != null)	window.clearInterval(_timer);
					_timer = window.setInterval(album_next, dispTimeout);
				})
				.bind("stop", function(){
					is_play = false;
					window.clearInterval(_timer);
					_timer = null;
				})
				.hover(function(){ is_over = true; }
					, function(){ is_over = false;})
			;

			// �⺻ CSS ����
			$carrousel_box.css({"position":"absolute", "width":li_width, "height":li_height*dispNumber, "overflow":"hidden"});
			$album_ul.css({"position":"absolute", "top":0, "left":-10000, "width":li_width, "height":li_height * li_count});
			$album_ul.css({"left":0});

			// ȭ��ǥ
			$album
				.find("> .arrow_prev").click(function(){ album_prev(false); }).end()
				.find("> .arrow_next").click(function(){ album_next(false); }).end();

			// Ȱ��ȭ�Ǿ��� �� ����
			$album_ul.find("> li")
			.bind("active", function(){
				$this = $(this);
				$old_img = $main_img.children("div.img_box");
				title = $this.attr("title");
				if(title.length && title.length > 0)
				{
					$new_img = $('<div class="img_box"><img src="'+$this.attr("image_src")+'" /><div class="comment">'+$this.attr("title")+'</div></div>');
					$new_img.find("> div.comment").css("opacity", 0.45);
				}
				else
					$new_img = $('<div class="img_box"><img src="'+$this.attr("image_src")+'" /></div>');
				$new_img.css("opacity", 0);
				$main_img.append($new_img);

				// FadeIn ȿ��
				$new_img.animate({"opacity":1}, 1000);
				$old_img.animate({"opacity":0}, 1000, function(){$(this).remove();});

				// ���� ���õȰ� ǥ��
				$this.addClass("on") // ���ݲ�
					 .siblings("li")
						.removeClass("on")
						.end()
				;
			})
			// Ŭ������ ��
			.each(function(i){
				$(this).click(function(){
					current = i;
					$(this).trigger("active");
				});
			});
		});
	}
});
