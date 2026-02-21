package com.sachal.githubactivity;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventParsingTest {

    private final Gson gson = new Gson();

    @Test
    void parsePushEvent() {
        String json = """
            [{
              "type": "PushEvent",
              "repo": { "name": "user/repo" },
              "payload": { "size": 3 }
            }]
            """;
        Event[] events = gson.fromJson(json, Event[].class);
        assertNotNull(events);
        assertEquals(1, events.length);
        assertEquals("PushEvent", events[0].type);
        assertEquals("user/repo", events[0].repo.name);
        assertEquals(3, events[0].payload.size);
    }

    @Test
    void parseMultipleEvents() {
        String json = """
            [
              { "type": "PushEvent", "repo": { "name": "a/b" }, "payload": { "size": 1 } },
              { "type": "CreateEvent", "repo": { "name": "x/y" } },
              { "type": "PushEvent", "repo": { "name": "c/d" }, "payload": { "size": 2 } }
            ]
            """;
        Event[] events = gson.fromJson(json, Event[].class);
        assertEquals(3, events.length);
        assertEquals("PushEvent", events[0].type);
        assertEquals("CreateEvent", events[1].type);
        assertEquals("PushEvent", events[2].type);
        assertEquals(1, events[0].payload.size);
        assertEquals(2, events[2].payload.size);
    }

    @Test
    void parseEventWithNullPayloadSize() {
        String json = """
            [{ "type": "PushEvent", "repo": { "name": "u/r" }, "payload": {} }]
            """;
        Event[] events = gson.fromJson(json, Event[].class);
        assertNotNull(events[0].payload);
        assertNull(events[0].payload.size);
    }

    @Test
    void parseEmptyArray() {
        Event[] events = gson.fromJson("[]", Event[].class);
        assertNotNull(events);
        assertEquals(0, events.length);
    }
}
