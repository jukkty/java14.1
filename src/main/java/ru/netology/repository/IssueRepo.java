package ru.netology.repository;

import ru.netology.domain.Issue;
import ru.netology.domain.NotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class IssueRepo {
    private final Collection<Issue> issues = new ArrayList<>();

    public void save(Issue issue) {
        issues.add(issue);
    }

    public void saveAll(Collection<Issue> issue) {
        issues.addAll(issue);
    }

    public Collection<Issue> findAll() {
        return issues;
    }

    public Issue findById(int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                return issue;
            }
        }
        return null;
    }

    public void openIssue(int id) {
        if (findById(id) != null) {
            for (Issue issue : issues) {
                if (issue.getId() == id) {
                    issue.setOpen(true);
                }
            }
        } else {
            throw new NotFoundException("Элемента с " + id + " не существует");
        }
    }

    public void closeIssue(int id) {
        if (findById(id) != null) {
            for (Issue issue : issues) {
                if (issue.getId() == id) {
                    issue.setOpen(false);
                }
            }
        } else {
            throw new NotFoundException("Элемента с " + id + " не существует");
        }
    }
}


