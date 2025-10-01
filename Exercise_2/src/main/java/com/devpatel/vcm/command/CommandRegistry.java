package com.devpatel.vcm.command;

import java.util.*;

public class CommandRegistry {
    private final Map<String, Command> map = new HashMap<>();

    public void register(Command c) { map.put(c.name(), c); }

    public Optional<Command> get(String name) { return Optional.ofNullable(map.get(name)); }

    public Collection<Command> all() { return map.values(); }
}
