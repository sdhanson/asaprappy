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
	  			src: ['sounds/travis_scott.mp3']
				}),
				color: '#1abc9c'
			},
			w: {
				sound: new Howl({
	  			src: ['sounds/1738.mp3']
				}),
				color: '#2ecc71'
			},
			e: {
				sound: new Howl({
	  				src: ['sounds/2chainzshort.mp3']
				}),
				color: '#3498db'
			},
			r: {
				sound: new Howl({
	  				src: ['sounds/alrightdrake.mp3']
				}),
				color: '#9b59b6'
			},
			t: {
				sound: new Howl({
	  				src: ['sounds/ahhh.mp3']
				}),
				color: '#34495e'
			},
			y: {
				sound: new Howl({
	  				src: ['sounds/anothaone.mp3']
				}),
				color: '#16a085'
			},
			u: {
				sound: new Howl({
	  				src: ['sounds/aybaby.mp3']
				}),
				color: '#27ae60'
			},
			i: {
				sound: new Howl({
	  				src: ['sounds/brrbrr.mp3']
				}),
				color: '#2980b9'
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
				color: '#2c3e50'
			},
			a: {
				sound: new Howl({
	  				src: ['sounds/mynameis.mp3']
				}),
				color: '#f1c40f'
			},
			s: {
				sound: new Howl({
	  				src: ['sounds/nickipurrrr.mp3']
				}),
				color: '#e67e22'
			},	
			d: {
				sound: new Howl({
	  				src: ['assets/sounds/piston-2.mp3']
				}),
				color: '#e74c3c'
			},
			f: {
				sound: new Howl({
	  				src: ['assets/sounds/prism-1.mp3']
				}),
				color: '#95a5a6'
			},
			g: {
				sound: new Howl({
	  				src: ['assets/sounds/prism-2.mp3']
				}),
				color: '#f39c12'
			},
			h: {
				sound: new Howl({
	  				src: ['assets/sounds/prism-3.mp3']
				}),
				color: '#d35400'
			},
			j: {
				sound: new Howl({
	  				src: ['assets/assets/sounds/splits.mp3']
				}),
				color: '#1abc9c'
			},
			k: {
				sound: new Howl({
	  				src: ['assets/sounds/squiggle.mp3']
				}),
				color: '#2ecc71'
			},
			l: {
				sound: new Howl({
	  				src: ['assets/sounds/strike.mp3']
				}),
				color: '#3498db'
			},
			z: {
				sound: new Howl({
	  				src: ['assets/sounds/suspension.mp3']
				}),
				color: '#9b59b6'
			},
			x: {
				sound: new Howl({
	  				src: ['assets/sounds/timer.mp3']
				}),
				color: '#34495e'
			},
			c: {
				sound: new Howl({
	  				src: ['assets/sounds/ufo.mp3']
			}),
			color: '#16a085'
			},
			v: {
				sound: new Howl({
	  				src: ['assets/sounds/veil.mp3']
				}),
				color: '#27ae60'
			},
			b: {
				sound: new Howl({
	  				src: ['assets/sounds/wipe.mp3']
				}),
				color: '#2980b9'
			},
			n: {
				sound: new Howl({
					src: ['assets/sounds/zig-zag.mp3']
				}),
				color: '#8e44ad'
			},
			m: {
				sound: new Howl({
	  				src: ['assets/sounds/moon.mp3']
				}),
				color: '#2c3e50'
			}
		};
	var circles = [];
	function onKeyDown(event) {
		<!-- If truthy (if keyData exists do this else dont do anything) -->
		if(keyData[event.key]) {
			var maxPoint = new Point(view.size.width, view.size.height);
			<!-- Basically it is doing this: new Point(Math.random(), Math.random()) -->
			var randomPoint = Point.random();
			<!-- Pretty much doing Math.random() * maxPoint -->
			var point = maxPoint * randomPoint;
			var newCircle = new Path.Circle(point, 500);
			newCircle.fillColor = keyData[event.key].color;
			keyData[event.key].sound.play();
			circles.push(newCircle);
			<!-- Cant do this because push() pushes in the string "orange" since it is the last time returned -->
			<!-- circles.push(new Path.Circle(point, 500).fillColor = "orange"); -->
		}
	}
	<!-- On each frame perform animate - change hue color and scale circle size -->
	function onFrame(event) {
		<!-- Loop through all circles and perform animate -->
		<!-- Optimization: need to remove circle once done -->
		for(var i = 0; i < circles.length; i++) {
			circles[i].fillColor.hue += 1;
			<!-- Scales by 90% of the size -->
			circles[i].scale(0.9);
			<!-- Remove circle from array if area is less than 1 -->
			if(circles[i].area < 1) {
				circles[i].remove();
				<!-- splice(index, amound to remove) -->
				circles.splice(i, 1);
				<!-- Console array shrinks till it is empty -->
				console.log(circles);
			}
		}
	}
	</script>
</head>

<body>
<div style="height: 100%; width: 100%; position: absolute; left: 0; padding: 0;" class="container-fluid" id="homepage">
	<canvas id="interactive" resize></canvas>
	<img style="max-height: 300px; position: fixed; top: 0; left: 0;" src="src/asapdiorlogo.png" id="logo">
</div>


</body>
</html>