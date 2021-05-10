import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
  labels: string[];
  series: number[];
}

function DonutChart() {

  const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/amount-by-seller`)
      .then(res => {
        const data = res.data as SaleSum[];
        const labels = data.map(x => x.sellerName);
        const series = data.map(x => x.sum);
        setChartData({ labels, series })
      })
      .catch(error => {
        console.log('erro ao realizar a requisição: ' + error)
      })
  }, [])

  const options = {
    legend: {
      show: true
    }
  }

  return (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type="donut"
      height="240"
    />
  );
}

export default DonutChart;
