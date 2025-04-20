import ReactECharts from 'echarts-for-react';
import { productGraph } from './data';



function App() {
  // const [count, setCount] = useState(0)
  const graph = productGraph;
  const option = {
    tooltip: {},
    legend: [
      {
        data: graph.categories.map((a) => {
          return a.name;
        })
      }
    ],
    toolbox: {

      feature: {
        dataZoom: {
          show: true,
          xAxixIndex: [0],
          yAxixIndex: [0],
        },
        restore: {},
        saveAsImage: {}
      }
    },
    series: [
      {
        name: 'Les Miserables',
        type: 'graph',
        layout: 'force',
        force: {
          repulsion: 1000,
          edgeLength: [50, 200],
          gravity: 0.1
        },
        data: graph.nodes,
        links: graph.links,
        categories: graph.categories,
        roam: true,
        label: {
          show: true,
          position: 'right',
          formatter: '{b}'
        },
        labelLayout: {
          hideOverlap: true
        },
        scaleLimit: {
          min: 0.4,
          max: 2
        },
        lineStyle: {
          color: 'source',
          curveness: 0.2
        }
      }
    ]
  };



  return (
    <div style={{ height: '100vh' }}>
      <h1 style={{ textAlign: 'center' }}>Knowledge Graph</h1>
      <ReactECharts
        option={option}
        style={{ height: '90%' }}
        onEvents={{
          click: (params: any) => {
            if (params.dataType === 'node') {
              console.log('Node clicked:', params.data);
            }
          },
          contextmenu: (params: any) => {
            if (params.dataType === 'node') {
              console.log('Node right-clicked:', params.data);
            }
          }
        }}
      />
    </div>

  );
}

export default App
