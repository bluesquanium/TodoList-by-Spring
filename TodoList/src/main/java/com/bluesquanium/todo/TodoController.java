package com.bluesquanium.todo;

import com.bluesquanium.model.Todo;
import com.bluesquanium.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService service;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    // 로그인된 username을 얻어내서 반환해준다.
    private String retrieveLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }

    // TodoList를 보여준다.
    @GetMapping(value = "/list-todos")
    public String showTodosList(ModelMap model) {
        String user = (String) model.get("name");
        model.addAttribute("todos", service.retrieveTodos(user));
        return "list-todos";
    }

    // 정렬 기준 : TargetDate
    @GetMapping(value = "/sort-targetdate")
    public String showTodosListByTargetDate(ModelMap model) {
        String user = (String) model.get("name");
        model.addAttribute("todos", service.retrieveTodosByTargetDate(user));
        return "list-todos";
    }

    // 정렬 기준 : IsDone
    @GetMapping(value = "/sort-isdone")
    public String showTodosListByIsDone(ModelMap model) {
        String user = (String) model.get("name");
        model.addAttribute("todos", service.retrieveTodosByIsDone(user));
        return "list-todos";
    }

    // Add 버튼을 눌러서 Addtodo 페이지로 이동 시.
    @GetMapping(value = "/add-todo")
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute("page", "Add");
        model.addAttribute("todo", new Todo());
        return "todo";
    }

    // Addtodo 페이지에서 Submit 버튼을 눌렀을 경우
    @PostMapping(value = "/add-todo")
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) { // Todo객체와 모델의 todo와 바로 연결시켜줌.
        if(result.hasErrors()) {
            return "todo";
        }

        String user = (String) model.get("name");
        service.addTodo(todo.getPriority(), user, todo.getDesc(), todo.getContent(), todo.getTargetDate(), false); // isDone은 하드코딩.
        model.clear();
        return "redirect:/list-todos";
    }

    // Update 버튼을 눌러서 Updatetodo 페이지로 이동 시.
    @GetMapping(value = "/update-todo")
    public String updateTodo(ModelMap model, @RequestParam int id) {
        model.addAttribute("page", "Update");

        String user = (String) model.get("name");
        Todo todo = service.retrieveTodo(user, id); // 한글 문제 있음
        model.addAttribute("todo", todo);

        return "todo";
    }

    // Update 페이지에서 Submit 버튼을 눌렀을 경우
    @PostMapping(value = "/update-todo")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String user = (String) model.get("name");
        Todo t = service.retrieveTodo(user, todo.getId());
        t.setPriority(todo.getPriority());
        t.setDesc(todo.getDesc());
        t.setContent(todo.getContent());
        t.setTargetDate(todo.getTargetDate());
        service.updateTodo(t);

        model.clear();
        return "redirect:/list-todos";
    }

    // 완료 여부('O' 또는 'X') 클릭 시 toggle 해줌
    @GetMapping(value = "/update-isdone")
    public String updateIsDone(ModelMap model, @RequestParam int id) {
        String user = (String) model.get("name");
        Todo todo = service.retrieveTodo(user, id);
        todo.setIsDone(!todo.getIsDone()); // toggle 'isDone'
        service.updateTodo(todo);

        return "redirect:/list-todos";
    }

    // Desc 클릭 시 해당 일정 상세 페이지로 이동
    @GetMapping(value = "/content")
    public String showContent(ModelMap model, @RequestParam int id) {
        String user = (String) model.get("name");
        Todo todo = service.retrieveTodo(user, id);
        model.addAttribute("todo", todo);

        return "content";
    }

    // Delete 버튼 누르면 해당 일정 삭제해줌.
    @GetMapping(value = "/delete-todo")
    public String deleteTodo(ModelMap model, @RequestParam int id) {
        service.deleteTodo(id);
        model.clear();
        return "redirect:/list-todos";
    }
}