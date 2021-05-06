package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.domain.NotFoundException;
import ru.netology.repository.IssueRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;

public class IssueManager {
    private final IssueRepo repository;

    public IssueManager(IssueRepo repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.save(issue);
    }

    public void addAll(Collection<Issue> issues) {
        repository.saveAll(issues);
    }

    public Collection<Issue> getAll() {
        return repository.findAll();

    }

    public void openIssue(int id) {
        repository.openIssue(id);
    }

    public void closeIssue(int id) {
        repository.closeIssue(id);
    }

    public Collection openedIssues() {
        Collection<Issue> opened = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (issue.isOpen()) {
                opened.add(issue);
            }
        }
        if (opened.isEmpty()) throw new NotFoundException("Открытых issue нет");
        return opened;
    }

    public Collection closedIssues() {
        Collection<Issue> closed = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (!issue.isOpen()) {
                closed.add(issue);
            }
        }
        if (closed.isEmpty()) throw new NotFoundException("Закрытых issue нет");
        return closed;
    }

    public Collection<Issue> filterByAuthor(Predicate<String> predicate) {
        Collection<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (predicate.test(issue.getAuthor())) {
                result.add(issue);
            }
        }
        return result;
    }

    public Collection<Issue> filteredByLabel(Predicate<String> predicate) {
        Collection<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (predicate.test(issue.getLabel())) {
                result.add(issue);
            }
        }
        return result;
    }

    public Collection<Issue> filteredByAssignee(Predicate<String> predicate) {
        Collection<Issue> result = new ArrayList<>();
        for (Issue issue : repository.findAll()) {
            if (predicate.test(issue.getAssignee())) {
                result.add(issue);
            }
        }
        return result;
    }

    public Collection<Issue> sortByIdNewest(Comparator<Issue> newest) {
        ArrayList<Issue> result = new ArrayList<>(repository.findAll());
        result.sort(newest);
        return result;
    }

    public Collection<Issue> sortByIdOldest(Comparator<Issue> oldest) {
        ArrayList<Issue> result = new ArrayList<>(repository.findAll());
        result.sort(oldest);
        return result;
    }
}
