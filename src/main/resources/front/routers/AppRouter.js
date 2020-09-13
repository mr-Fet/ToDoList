import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Header from '../components/Header';
import AddBook from '../components/addTask';

const AppRouter = () => (
    <BrowserRouter>
        <div className='container'>
            <Header />
            <Switch>
                <Route path="/add" component={addTask} />

              
            </Switch>
        </div>
    </BrowserRouter>
);

export default AppRouter;