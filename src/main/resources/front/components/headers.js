import React from 'react';
import { NavLink } from 'react-router-dom';

const Header = () => (
    <header>
        <h2>TO DO APP</h2>

        <div className='header__nav'>

            <NavLink to='/add' activeClassName='activeNav'>Add Task</NavLink>
        </div>
    </header>
);

export default Header;