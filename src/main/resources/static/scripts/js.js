google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawCrosshairs);

function drawCrosshairs() {
    var data = new google.visualization.DataTable();
    data.addColumn('date', 'X');
    data.addColumn('number', 'soilMoisture1');
    data.addColumn('number', 'soilMoisture2');
    data.addColumn('number', 'soilMoisture3');
    data.addColumn('number', 'soilMoisture4');

    if(moistureMeasurements != null) {
        console.log(dataTransfer(moistureMeasurements))
        data.addRows(dataTransfer(moistureMeasurements))
    } else {
        console.log("brak danych!")
    }

    var options = {
        hAxis: {
            title: 'Time'
        },
        vAxis: {
            title: 'Popularity'
        },
        colors: ['#a52714', '#097138'],
        crosshair: {
            color: '#000',
            trigger: 'selection'
        }
    };

    var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

    chart.draw(data, options);
    chart.setSelection([{row: 38, column: 1}]);
}

const dataTransfer = (dataArray) => {
    let newArray = [];
    dataArray.forEach(subArray => newArray.push(subArrayTransfer(subArray)))
    return newArray
}

const subArrayTransfer = (subArray) => {
    return [new Date(subArray[0]), subArray[1], subArray[2], subArray[3], subArray[4]]
}