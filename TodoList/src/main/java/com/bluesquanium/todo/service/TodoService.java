package com.bluesquanium.todo.service;

import com.bluesquanium.model.Todo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>(); // Todo들이 저장될 장소.
    private static int todoCount = 3; // 현재 Todo갯수

    // 샘플 todo들
    static {
        todos.add(new Todo(1, 1, "guest", "test1", "content1", new Date(), false));
        todos.add(new Todo(2, 10, "guest", "test2", "content2",new Date(), false));
        todos.add(new Todo(3, 8, "guest", "test3", "content3", new Date(), false));
    }

    static class ComparePriorityAsc implements Comparator<Todo> {
        @Override
        public int compare(Todo t1, Todo t2) {
            if(t1.getPriority() != t2.getPriority())
                return t1.getPriority() < t2.getPriority() ? -1 : t1.getPriority() > t2.getPriority() ? 1 : 0;
            else {
                return t1.getId() < t2.getId() ? -1 : t1.getId() > t2.getId() ? 1 : 0;
            }
        }
    }

    static class CompareTargetDateDesc implements Comparator<Todo> {
        @Override
        public int compare(Todo t1, Todo t2) {
            if(t1.getTargetDate()==null) {
                return -1;
            }
            else if( t2.getTargetDate()==null) {
                return 1;
            }
            else {
                return (t1.getTargetDate()).compareTo(t2.getTargetDate());
            }
        }
    }

    static class CompareIsDoneDesc implements Comparator<Todo> {
        @Override
        public int compare(Todo t1, Todo t2) {
            return t1.getIsDone()? (t2.getIsDone()? 0 : 1) : -1 ;
        }
    }

    // 해당 user의 to do list 불러옴.
    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }

        Collections.sort(filteredTodos, new ComparePriorityAsc());
        return filteredTodos;
    }

    // 해당 user의 to do list 불러옴 (TargetDate를 통해 정렬)
    public List<Todo> retrieveTodosByTargetDate(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }

        Collections.sort(filteredTodos, new CompareTargetDateDesc());
        return filteredTodos;
    }

    // 해당 user의 to do list 불러옴 (IsDone를 통해 정렬)
    public List<Todo> retrieveTodosByIsDone(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }

        Collections.sort(filteredTodos, new CompareIsDoneDesc());
        return filteredTodos;
    }

    // id, user를 통해 Todo검색
    public Todo retrieveTodo(String user, int id) {
        for (Todo todo : todos) {
            if( todo.getId() == id ) {
                if( todo.getUser().equals(user) ) {
                    return todo;
                }
                else {
                    return null;
                }
            }
        }
        return null;
    }

    // Todo추가
    public void addTodo(int priority, String name, String desc, String content, Date targetDate, boolean isDone) {
        todos.add(new Todo(++todoCount, priority, name, desc, content, targetDate, isDone));
    }

    // Todo업데이트
    public void updateTodo(Todo todo) {
        todos.remove(todo); // remove가 todo의 equals를 오버라이딩 하는 듯.
        todos.add(todo);
    }

    // Todo삭제
    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while(iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
