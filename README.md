# tablefiltersortparser
parse expression to filter or sort table, need [MVEL](http://mvel.codehaus.org) dependency

There are only two methods. Use them like:
```java
TableFilterTextParser.parseText(jTable, expression)
TableSortTextParser.ParserText(jTable, expression , SortOrder.ASCENDING);
```
