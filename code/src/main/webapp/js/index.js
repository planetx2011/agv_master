define(function (require) {


    var data = [[{"x": 100, "y": 100}, {"x": 100, "y": 600}, {"x": 800, "y": 600}, {"x": 800, "y": 350}, {
        "x": 100,
        "y": 100
    }], [{"x": 200, "y": 200}, {"x": 200, "y": 300}, {"x": 400, "y": 300}, {"x": 200, "y": 200}], [{
        "x": 100,
        "y": 100
    }, {"x": 200, "y": 200}], [{"x": 200, "y": 300}, {"x": 100, "y": 100}]]
    var canvas = document.getElementById("myCanvas");

    var ctx = canvas.getContext("2d");

    function drawRoute(data) {
        for (var i = 0, size1 = data.length; i < size1; i++) {
            var coodinate = data[i];
            var x1 = coodinate[0].x;
            var y1 = coodinate[0].y;
            ctx.moveTo(x1, y1);
            for (var j = 1, size2 = coodinate.length; j < size2; j++) {
                var x = coodinate[j].x;
                var y = coodinate[j].y;
                ctx.lineTo(x, y);

            }
        }
        ctx.stroke();
    }

    // function Route() {
    //
    // }

    function Car(x, y,color) {
        this.x = x;
        this.y = y;
        this.color= color;
    }
    Car.prototype.updateCoodinate =function (x,y) {
        this.x = x;
        this.y = y;
    };
    Car.prototype.drawCar = function () {
        var circle = function (x, y, radius, fillCircle) {
            ctx.beginPath();
            ctx.arc(x, y, radius, 0, Math.PI * 2, false);
            if (fillCircle) {
                ctx.fill();
            } else {
                ctx.stroke();
            }
        }
        ctx.lineWidth = 1;
        ctx.strokeStyle = "black";
        ctx.fillStyle = this.color;
        circle(this.x, this.y, 8, true);
        circle(this.x, this.y, 8, false);
        circle(this.x - 2, this.y - 1, 2, false);
        circle(this.x + 2, this.y - 1, 2, false);
    };


    function drawCar(x, y) {
        var circle = function (x, y, radius, fillCircle) {
            ctx.beginPath();
            ctx.arc(x, y, radius, 0, Math.PI * 2, false);
            if (fillCircle) {
                ctx.fill();
            } else {
                ctx.stroke();
            }
        }
        ctx.lineWidth = 1;
        ctx.strokeStyle = "black";
        ctx.fillStyle = "gold";
        circle(x, y, 8, true);
        circle(x, y, 8, false);
        circle(x - 2, y - 1, 2, false);
        circle(x + 2, y - 1, 2, false);
    };


    function updateCarCoordinate(coordinate) {
        for (var i = 0, size = coordinate.length; i < size; i++) {
            drawCar(coordinate[i].x, coordinate[i].y);
        }
    }


    var moveI = 0;
    var delay = function (callback, start, end) {
        if (moveI === 0) {
            callback(start, end);
            return;
        } else {
            setTimeout(function () {
                delay(callback, start, end);
            }, 100)
        }
    }
    var car = new Car(0, 0,"gold");
    function move(start, end) {
        moveI = 1;
        var w = Math.abs(end.x - start.x);
        var h = Math.abs(end.y - start.y);
        var l = Math.pow(Math.pow(w, 2) + Math.pow(h, 2), 1 / 2);
        var moveX;
        var moveY;

        var interval = setInterval(function () {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            drawRoute(data);
            car.updateCoodinate(moveX,moveY);
            car.drawCar();
            if (moveI < l) {
                moveI++;
                if (start.x < end.x) {
                    moveX = start.x + w / l * moveI;

                } else {
                    moveX = start.x - w / l * moveI;
                }
                if (start.y < end.y) {
                    moveY = start.y + h / l * moveI;

                } else {
                    moveY = start.y - h / l * moveI;
                }


            } else {
                clearInterval(interval);
                moveI = 0;
            }
        }, 30);

    }

    for (var s = 0; s < 2; s++) {
        delay(move, {"x": 800, "y": 350}, {"x": 100, "y": 100});
        delay(move, {"x": 100, "y": 100}, {"x": 200, "y": 200});
        delay(move, {"x": 200, "y": 200}, {"x": 200, "y": 300});
        delay(move, {"x": 200, "y": 300}, {"x": 100, "y": 100});
        delay(move, {"x": 100, "y": 100}, {"x": 100, "y": 600});
        delay(move, {"x": 100, "y": 600}, {"x": 800, "y": 600});
        delay(move, {"x": 800, "y": 600}, {"x": 800, "y": 350});

    }
});