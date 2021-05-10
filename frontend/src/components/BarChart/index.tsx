import axios from 'axios';
import { useEffect } from 'react';
import { useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSuccess } from 'types/sale';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

type SeriesData = {
  name: string;
  data: number[];
}

type ChartData = {
  labels: {
    categories: string[];
  };
  series: SeriesData[];
}

function BarChart() {

  const [chartData, setChartData] = useState<ChartData>({
    labels: {
      categories: []
    },
    series: [
      { name: '', data: [] }
    ]
  })

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/success-by-seller`)
      .then(res => {
        const data = res.data as SaleSuccess[];
        const labels = data.map(x => x.sellerName);
        const series = data.map(x => round(100.0 * x.deals / x.visited, 1));
        setChartData({
          labels: {
            categories: labels
          },
          series: [
            { name: '% Success', data: series }
          ]
        })
      })
      .catch(error => {
        console.log('erro ao realizar a requisição: ' + error)
      })
  }, [])

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      }
    },
  };

  return (
    <Chart
      options={{ ...options, xaxis: chartData.labels }}
      series={chartData.series}
      type="bar"
      height="240"
    />
  );
}

export default BarChart;
