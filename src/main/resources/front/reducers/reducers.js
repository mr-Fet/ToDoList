const tasksReducerDefaultState = [];

export default (state = tasksReducerDefaultState, action) => {
    switch (action.type) {
        case 'ADD_TASK':
            return [
                ...state,
                action.task
            ];
        case 'REMOVE_TASK':
            return state.filter(({ id }) => id !== action.id);

            default:
            return state;
    }
};