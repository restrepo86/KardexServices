import React from 'react';
import ReactDOM from 'react-dom';
import { HashRouter  } from 'react-router-dom';
import { LocaleProvider } from 'antd';
import es_ES from 'antd/lib/locale-provider/es_ES';
import 'moment/locale/es';
import { kardexServices } from './services/Services';
import Process from './stores/Process';
import ProductStore from './stores/ProductStore';
import './index.css';
import App from './App';


const process =  new Process();
const productStore = new ProductStore(kardexServices, process);
const stores = { productStore };

const routes = (
    <HashRouter>
        <LocaleProvider locale={es_ES}>
          <App stores={stores} />
        </LocaleProvider>
    </HashRouter>
);

ReactDOM.render(routes, document.getElementById('root'));
