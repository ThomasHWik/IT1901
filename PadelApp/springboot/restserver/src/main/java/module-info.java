module PadelApp.springboot.restserver {
    requires com.fasterxml.jackson.databind;

    requires spring.web;
    requires spring.beans;
    requires spring.boot;
    requires spring.context;
    requires spring.boot.autoconfigure;

    requires PadelApp.core;

    opens PadelApp.springboot.restserver to spring.beans, spring.context, spring.web, spring.core;
}
