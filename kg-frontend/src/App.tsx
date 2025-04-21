import ReactECharts from 'echarts-for-react';
import { useEffect, useState } from 'react';
import jsondata from "./assets/products.json";


function App() {
  // const [count, setCount] = useState(0)
  const [graph, setGraph] = useState<{ nodes: any[]; edges: any[], categories: any[] }>({
    nodes: [],
    edges: [],
    categories: []
  });
  useEffect(() => {
    setGraph(jsondata);
  }, []);
  const option = {
    tooltip: {},
    legend: [
      {
        data: graph.categories.map((a) => {
          return a.name;
        }),
      }
    ],
    toolbox: {

      feature: {
        restore: {},
        saveAsImage: {}
      }
    },
    series: [
      {
        // name: 'Les Miserables',
        type: 'graph',
        layout: 'force',
        force: {
          repulsion: 500,
          edgeLength: [50, 200],
          gravity: 0.1
        },
        nodes: graph.nodes,
        edges: graph.edges,
        categories: graph.categories,
        roam: true,
        label: {
          show: true,
          position: 'right',
          formatter: '{b}',
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
          curveness: 0.3
        },
        emphasis: {
          focus: 'adjacency',
          label: {
            position: 'right',
            show: true
          }
        }
      }
    ]
  };

  return (
    <div style={{ height: '100vh' }}>
      <div style={{padding:'5px', backgroundColor: '#11319a',color:'white',textAlign:'center' ,fontWeight:'bold' ,fontSize:'42px'}}>
        Knowledge Graph
      </div>

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
