import React from 'react';
import { Route } from 'react-router';
import { Switch } from 'react-router-dom';
import InventarioTodoUnoContainer from './containers/InventarioTodoUnoContainer';

const Main = (props) => (
    <main>
        <Switch>
            <Route exact path="/" render={(routeProps) => (
              <InventarioTodoUnoContainer {...routeProps} {...props} />
            )}/>
        </Switch>
    </main>
);

export default Main;
