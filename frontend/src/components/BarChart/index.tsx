import Chart from 'react-apexcharts';

type ChartData = {
  labels: string[];
  series: number[];
}

function BarChart() {

  let chartData: ChartData = {
    labels: [],
    series: []
  };

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      }
    },
  };

  const mockData = {
    labels: {
      categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    },
    series: [
      {
        name: "% Sucesso",
        data: [43.6, 67.1, 67.7, 45.6, 71.1]
      }
    ]
  };

  return (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type="bar"
      height="240"
    />
  );
}

export default BarChart;
