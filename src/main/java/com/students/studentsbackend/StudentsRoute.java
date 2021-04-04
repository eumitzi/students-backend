package com.students.studentsbackend;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

@Component
public class StudentsRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(Student.class);
        from("file:data/csv/input?fileName=file4.txt&noop=true")
                .unmarshal(bindy)
                .to("log:?level=INFO&showBody=true&showHeaders=true")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println(exchange.getIn().getBody().toString());
                    }
                });
                //.to("file:data/csv/output?fileName=fileOutput4.txt");
    }
}
