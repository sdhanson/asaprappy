<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

	<link rel="stylesheet" type="text/css" href="stylesheets/index.css">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	
	<link rel="icon" href="src/asapfavicon.png">
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/paper.js/0.10.3/paper-full.js"></script>

	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/howler/2.0.3/howler.js"></script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script type="text/paperscript" canvas="interactive">
		var keyData = {
			q: {
				sound: new Howl({
	  			src: ['sounds/yeahtravis.mp3']
				}),
				id: 'travis',
				time: 2,
			},
			w: {
				sound: new Howl({
	  			src: ['sounds/1738.mp3']
				}),
				id: 'fetty'
			},
			e: {
				sound: new Howl({
	  				src: ['sounds/2chainzshort.mp3']
				}),
				id: '2chainz'
			},
			r: {
				sound: new Howl({
	  				src: ['sounds/alrightdrake.mp3']
				}),
				id: 'drake'
			},
			t: {
				sound: new Howl({
	  				src: ['sounds/ahhh.mp3']
				}),
				id: 'chance'
			},
			y: {
				sound: new Howl({
	  				src: ['sounds/anothaone.mp3']
				}),
				id: 'djkhaled'
			},
			u: {
				sound: new Howl({
	  				src: ['sounds/aybaby.mp3']
				}),
				id: 'hurricanechris'
			},
			i: {
				sound: new Howl({
	  				src: ['sounds/brrbrr.mp3']
				}),
				id: '2chainz'
			},
			o: {
				sound: new Howl({
					src: ['sounds/ladiesandgentlemann.mp3']
				}),
				color: '#8e44ad'
			},
			p: {
				sound: new Howl({
	  				src: ['sounds/mr305.mp3']
				}),
				id: 'pitbull'
			},
			a: {
				sound: new Howl({
	  				src: ['sounds/mynameis.mp3']
				}),
				id: 'eminem'
			},
			s: {
				sound: new Howl({
	  				src: ['sounds/nickipurrrr.mp3']
				}),
				id: 'nicki'
			},	
			d: {
				sound: new Howl({
	  				src: ['sounds/woah.mp3']
				}),
				id: 'bigsean'
			},
			f: {
				sound: new Howl({
	  				src: ['sounds/liljon.mp3']
				}),
				id: 'liljon'
			},
			g: {
				sound: new Howl({
	  				src: ['sounds/jayz.mp3']
				}),
				id: 'jayz'
			},
			h: {
				sound: new Howl({
	  				src: ['sounds/panda.mp3']
				}),
				id: 'desiigner'
			},
			j: {
				sound: new Howl({
	  				src: ['sounds/frenchmontana.mp3']
				}),
				id: 'frenchmontana'
			},
			k: {
				sound: new Howl({
	  				src: ['sounds/drummaboy.mp3']
				}),
				id: 'drummaboy'
			},
			l: {
				sound: new Howl({
	  				src: ['sounds/schoolboyq.mp3']
				}),
				id: 'schoolboyq'
			},
			z: {
				sound: new Howl({
	  				src: ['sounds/djmustard.mp3']
				}),
				id: 'djmustard'
			},
			x: {
				sound: new Howl({
	  				src: ['sounds/souljaboy.mp3']
				}),
				id: 'souljaboy'
			},
			c: {
				sound: new Howl({
	  				src: ['sounds/nickiyoungmoney.mp3']
			}),
				id: 'nicki2'
			},
			v: {
				sound: new Howl({
	  				src: ['sounds/djkhaled.mp3']
				}),
				id: 'djkhaled'
			},
			b: {
				sound: new Howl({
	  				src: ['sounds/souljaboy2.mp3']
				}),
				id: 'souljaboy'
			},
			n: {
				sound: new Howl({
					src: ['sounds/straightuptravis.mp3']
				}),
				id: 'travis'
			},
			m: {
				sound: new Howl({
	  				src: ['sounds/ladiesandgentlemann.mp3']
				}),
				id: 'drummaboy'
			}
		};

	var rasters = [];
	var time = 0;
	function showImage(id) {
		// Create a raster item using the image tag with id='mona'
		if(id == null) { id = 'asap'; }

		var raster = new Raster(id);

		var maxPoint = new Point(view.size.width, view.size.height);
		
		var randomPoint = Point.random();
		
		var point = maxPoint * randomPoint;

		// Move the raster to the center of the view
		raster.position = point;

		// Scale the raster by 50%
		raster.scale(0.25);

		// Rotate the raster by 45 degrees:
		raster.rotate(0);

		// set paths !!!
		var num = 2;
		if(id.localeCompare('asap') == 0) { num = 3; }
		if(id.localeCompare('chance') == 0) { num = 4; }
		if(id.localeCompare('drake') == 0) { num = 5; }
		if(id.localeCompare('nicki') == 0) { num = 6; }
		rasters.push({image: raster, time: 2, path: num});
	}

	function onKeyDown(event) {

		if(keyData[event.key]) {
			showImage(keyData[event.key].id);
			keyData[event.key].sound.play();
		}

	}

	// Animation frames
	function onFrame(event) {
		
		for(var i=0; i < rasters.length; i++) {
			
			// If image time is up, destroy
			rasters[i].time -= event.delta;
			if(rasters[i].time < 0) {
				rasters[i].image.remove();
				rasters.splice(i, 1);
				continue;
			}

			// define paths !!!!
			switch(rasters[i].path) {
				case 3:
					// var sinus = Math.sin(event.time * 4 + i);
					// rasters[i].image.position.x = sinus * 100 + 350;
					rasters[i].image.position.y -= 5;
					break;
				case 4:
					rasters[i].image.rotate(-180 * event.delta);
					break;
				case 5:
					rasters[i].image.position.x += 1.001;
					break;
				case 6:
					rasters[i].image.position += 2;
					break;
				default:
					rasters[i].image.position.x += 1;
					rasters[i].image.scale(0.99);
					break;
					
			}

		}
	}
	</script>
	
	<script>
	$(document).ready(function() {
		$("#lilasap").on("mouseenter", function() {
		    $("#sidebar").hide().removeClass("d-none").fadeIn();
/*  		    $("#lilasap").addClass("invisible");
 */ 		});
		
		
		$("#sidebar").on("mouseleave", function() {
		    $("#sidebar").addClass("d-none");
/* 		    $(".loaded-quote").removeClass("invisible");
 */		});
	});

	</script>
</head>

<body>

<!-- main homepage body -->
<div  class="container-fluid col-12" id="homepage">
	<canvas id="interactive" resize></canvas>
	<!-- visible logo -->
	<img src="src/asapdiorlogo.png" id="logo">
	
	<!-- All of the loaded images hidden :) -->
	<img class="d-none" id="asap" src="src/asapdiorlogoblue.png">
	<img class="d-none" id="travis" src="src/travis.png">
	<img class="d-none" id="fetty" src="src/fettywap.png">
	<img class="d-none" id="2chainz" src="src/2chainz.png">
	<img class="d-none" id="djkhaled" src="src/djkhaled.png">
	<img class="d-none" id="drake" src="src/drake.png">
	<img class="d-none" id="eminem" src="src/eminem.png">
	<img class="d-none" id="pitbull" src="src/pitbull.png">
	<img class="d-none" id="nicki" src="src/nicki.png">
	<img class="d-none" id="chance" src="src/chance.png">
	<img class="d-none" id="bigsean" src="src/bigsean.png">
	<img class="d-none" id="liljon" src="src/liljon.png">
	<img class="d-none" id="drummaboy" src="src/drummaboy.png">
	<img class="d-none" id="desiigner" src="src/desiigner.png">
	<img class="d-none" id="djmustard" src="src/djmustard.png">
	<img class="d-none" id="frenchmontana" src="src/frenchmontana.png">
	<img class="d-none" id="hurricanechris" src="src/hurricanechris.png">
	<img class="d-none" id="jayz" src="src/jayz.png">
	<img class="d-none" id="liljon" src="src/liljon.png">
	<img class="d-none" id="nicki2" src="src/nicki2.png">
	<img class="d-none" id="schoolboyq" src="src/schoolboyq.png">
	<img class="d-none" id="souljaboy" src="src/souljaboy2.png">
		
	<!-- sidebar image -->
	<img class="rounded-circle" style="max-height: 200px; position: fixed; bottom: 0; right: -110px;" id="lilasap" src="src/rotateno.png">
	
	
</div>

<!-- sidebar: hover over lil asap and boxes slide out!! -->
<div class="col-2 d-none float-right" style="height: 100vh;" id="sidebar">

	<div class="row justify-content-center" style="margin-top: 50%; margin-bottom: 50%;">
		<div> screen name w padaloma</div>
		<div>most used thing</div>
		<div>random rapper image</div>
		<div>friend user list and active or not</div>
	</div>
	
	
	
	
	<img class="rounded-circle" style="max-height: 200px; position: fixed; bottom: 0; right: -110px;" id="lilasap" src="src/rotateno.png">
	
</div>


</body>
</html>