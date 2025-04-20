export const basicgraph = {
    nodes: [
        { id: 'npm', name: 'npm', symbolSize: 50, category: 0 },
        { id: 'react', name: 'react', symbolSize: 30, category: 1 },
        { id: 'webpack', name: 'webpack', symbolSize: 30, category: 2 },
        { id: 'babel', name: 'babel', symbolSize: 30, category: 3 },
        { id: 'eslint', name: 'eslint', symbolSize: 20, category: 4 },
        { id: 'typescript', name: 'typescript', symbolSize: 20, category: 5 },
        { id: 'jest', name: 'jest', symbolSize: 20, category: 6 },
        { id: 'redux', name: 'redux', symbolSize: 20, category: 1 },
        { id: 'react-router', name: 'react-router', symbolSize: 20, category: 1 },
    ],
    links: [
        { source: 'npm', target: 'react' },
        { source: 'npm', target: 'webpack' },
        { source: 'npm', target: 'babel' },
        { source: 'npm', target: 'eslint' },
        { source: 'npm', target: 'typescript' },
        { source: 'npm', target: 'jest' },
        { source: 'react', target: 'redux' },
        { source: 'react', target: 'react-router' },
    ],
    categories: [
        { name: 'Core' },
        { name: 'Frontend' },
        { name: 'Build Tools' },
        { name: 'Transpilers' },
        { name: 'Linting' },
        { name: 'Type Checking' },
        { name: 'Testing' },
    ]
}

export const productGraph = {
    nodes: [
        { id: 'ProductA', name: 'ProductA', symbolSize: 50, category: 0 },
        { id: 'ProductB', name: 'ProductB', symbolSize: 50, category: 1 },
        { id: 'Engineer1', name: 'Engineer1', symbolSize: 30, category: 2 },
        { id: 'Engineer2', name: 'Engineer2', symbolSize: 30, category: 2 },
        { id: 'Engineer3', name: 'Engineer3', symbolSize: 30, category: 2 },
        { id: 'Engineer4', name: 'Engineer4', symbolSize: 30, category: 2 },
        { id: 'Engineer5', name: 'Engineer5', symbolSize: 30, category: 2 },
        { id: 'Engineer6', name: 'Engineer6', symbolSize: 30, category: 2 },
        { id: 'Engineer7', name: 'Engineer7', symbolSize: 30, category: 2 },
        { id: 'Engineer8', name: 'Engineer8', symbolSize: 30, category: 2 },
        { id: 'Director', name: 'Director', symbolSize: 40, category: 2 },
    ],
    links: [
        { source: 'ProductA', target: 'Engineer1' },
        { source: 'ProductA', target: 'Engineer2' },
        { source: 'ProductA', target: 'Engineer5' },
        { source: 'ProductA', target: 'Engineer6' },
        { source: 'ProductB', target: 'Engineer3' },
        { source: 'ProductB', target: 'Engineer4' },
        { source: 'ProductB', target: 'Engineer7' },
        { source: 'ProductB', target: 'Engineer8' },
        { source: 'ProductA', target: 'Director' },
        { source: 'ProductB', target: 'Director' },
    ],
    categories: [
        { name: 'Cat A' },
        { name: 'Cat B' },
        { name: 'Person' },
    ]
}
