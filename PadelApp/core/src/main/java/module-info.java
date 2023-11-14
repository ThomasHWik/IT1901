module PadelApp.core {
    requires transitive com.fasterxml.jackson.databind;
    requires java.net.http;
    exports PadelApp.core;
    exports PadelApp.json;
}
