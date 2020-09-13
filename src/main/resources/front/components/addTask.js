import React from 'react';
import TaskForm from 'TaskForm';
import { connect } from 'react-redux';
import { addTask } from '../action/taskAction';

const AddTask = (props) =>
    <div>
        <h3>Set Task information:</h3>
        <taskform onsubmitbook="{(task)"> {
            props.dispatch(addTask(task));
            props.history.push('/');
        }}
            />
        </taskform></div>
);

export default connect()(addTask());