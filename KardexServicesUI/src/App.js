import React from 'react';
import Main from './views/Main';

const appStyle = {
    boxContainer : {
        border: '1px solid blue',
        width: '90%',
        margin: 'auto',
    },
    titleContainer: {
        padding: '10px 5px 1px 15px',
        backgroundColor: '#095aa5',
    },
    windowTitle: {
        fontSize: 18,
        color: '#FFF'
    }
}

const App = (props) => (
    <div style={appStyle.boxContainer}>
        <div style={appStyle.titleContainer}>
            <h1 style={appStyle.windowTitle}>Inventario Todo1</h1>
        </div>
        <div style={{padding: 15}}>
            <Main {...props} />
        </div>
    </div>
);

export default App;
