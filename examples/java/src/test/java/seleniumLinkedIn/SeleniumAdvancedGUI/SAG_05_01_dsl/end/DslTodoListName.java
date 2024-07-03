package seleniumLinkedIn.SeleniumAdvancedGUI.SAG_05_01_dsl.end;

class DslTodoListName {
    private final String name;

    public DslTodoListName() {
        this(new DslRandomString("-").generate());
    }

    public DslTodoListName(final String todoListName) {
        this.name = todoListName;
        System.out.println("Generate TODO LIST: " + name);
    }

    public String getName() {
        return name;
    }

}
