import React from 'react';

export default class TaskForm extends React.Component {
    constructor(props) {
        super(props);
        this.onTaskIdChange = this.onTaskIdChange.bind(this);
        this.onPriorityChange = this.onPriorityChange.bind(this);
        this.onDescriptionChange = this.onDescriptionChange.bind(this);
        this.onExecutorChange = this.onExecutorChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);

        this.state = {
            taskId: props.task ? props.task.taskid : 0,
            priority: props.task ? props.task.priority : 0,
            description: props.task ? props.task.description : '',
            executor: props.task ? props.task.executors : '',

            error: ''
        };
    }

    onTaskIdChange(e) {
        const taskId = e.target.value;
        this.setState(() => ({ taskId: taskId }));
    }

    onPriorityChange(e) {
        const priority = parseInt(e.target.value);
        this.setState(() => ({ priority: priority }));
    }

    onDescriptionChange(e) {
        const description = e.target.value;
        this.setState(() => ({ description: description }));
    }

    onExecutorChange(e) {
        const executor = e.target.value;
        this.setState(() => ({ executor: executor }));
    }

    onSubmit(e) {
        e.preventDefault();

        if (!this.state.description || !this.state.priority || !this.state.executor) {
            this.setState(() => ({ error: 'Please set title & author & published!' }));
        } else {
            this.setState(() => ({ error: '' }));
            this.props.onSubmitTask(
                {
                    taskId: this.state.taskId,
                    priority: this.state.priority,
                    description: this.state.description,
                    executor: this.state.executor
                }
            );
        }
    }

    render() {
        return (
            <div>
                {this.state.error && <p className='error'>{this.state.error}</p>}
                <form onSubmit={this.onSubmit} className='add-task-form'>

                    <input type="number" placeholder="priority"
                           value={this.state.priority}
                           onChange={this.onPriorityChange} />
                    <br />

                    <textarea placeholder="description"
                              value={this.state.description}
                              onChange={this.onDescriptionChange} />
                    <br />

                    <input type="text" placeholder="executor"
                           value={this.state.executor}
                           onChange={this.onExecutorChange} />
                    <br />
                    <button>Add Task</button>
                </form>
            </div>
        );
    }
}