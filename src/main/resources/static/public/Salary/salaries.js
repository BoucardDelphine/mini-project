let ctx = document.getElementById('salaries-chart').getContext('2d');


let getDataPost = function (url) {
    return $.ajax({
        url: url,
        type: 'POST',
        data: {},
        dataType: 'json'
    });
};

let labels = [];

getDataPost('/salaries-json').then(function (data) {
    let salaries =[];
    for (let salary of data){
        salaries.push(salary.salary);
    }
    let minSalary = salaries[0].salary;
    let maxSalary = salaries[salaries.length - 1].salary;
    let size = (maxSalary - minSalary) / 10;
    let offsets = [...new Array(11)].map((_, i) => 2100 + size * (i));

    for (let i = 0; i < offsets.length - 1; i++) {
        let label = offsets[i].toString() + ' - ' + offsets[i + 1].toString();
        labels.push(label);
    }
    let chart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: "Number of people",
                backgroundColor: 'rgb(255, 99, 132)',
                borderColor: 'rgb(255, 99, 132)',
                data: math.quantileSeq(salaries, [1/10, 2/12, 3/10, 4/10, 5/10, 6/10, 7/10, 8/10, 9/10cd ]),
            }]
        },
        options: {}
    });
});

