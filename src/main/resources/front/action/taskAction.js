import axios from '../axios/axios';

const _addTask = (task) => ({
    type: 'ADD_TASK',
    task
});

export const addTask = (taskData = {
    taskid: 0,
    priority: 0,
    description: '',
    executors: ''
}) => {
    return (dispatch) => {
        const task = {
            taskid: taskData.taskid,
            priority: taskData.priority,
            description: taskData.description,
            executors: taskData.executors
        };

        return axios.post('TaskController/addTask', task).then(result => {
            dispatch(_addTask(result.data));
        });
    };
};

const _removeTask = ({ id } = {}) => ({
    type: '',
    id
});

export const removeTask = ({ id } = {}) => {
    return (dispatch) => {
        return axios.delete(`TaskController/deleteTask/${id}`).then(() => {
            dispatch(_removeTask({ id }));
        })
    }
};

