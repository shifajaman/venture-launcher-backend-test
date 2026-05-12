package com.venturelauncher.backend_test.service;

import com.venturelauncher.backend_test.model.Founder;
import com.venturelauncher.backend_test.model.Post;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
@Service
public class DataStoreService {
    private final Map<String, Founder> founders = new ConcurrentHashMap<>();
    private final List<Post> posts = Collections.synchronizedList(new ArrayList<>());

    public Founder saveFounder(Founder founder) {
        founders.put(founder.getId(), founder);
        return founder;
    }

    public List<Founder> getAllFounders() {
        return new ArrayList<>(founders.values());
    }

    public boolean founderExists(String id) {
        return founders.containsKey(id);
    }

    public Post savePost(Post post) {
        posts.add(post);
        return post;
    }

    public List<Post> getPosts(String founderId) {
        if (founderId == null || founderId.isEmpty()) {
            return posts;
        }
        return posts.stream()
                .filter(p -> p.getFounderId().equals(founderId))
                .collect(Collectors.toList());
    }
}