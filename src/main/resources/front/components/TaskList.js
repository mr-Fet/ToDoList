import React from 'react';
import { connect } from 'react-redux';
import TaskForm from './TaskForm';

const TaskList = (props) => (
    <div>
        Task List:
        <ul>
            {props.task.map(task => {
                return (
                    <li key="{task.taskId}">
                        <task {...task}="">
                        </task></li>
                );
            })}
        </ul>

    </div>
);

const mapStateToProps = (state) => {
    return {
        task: state
    };
}

export default connect(mapStateToProps)(TaskList);
