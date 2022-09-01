package example.JPA_N1.service;

import example.JPA_N1.domain.Academy;
import example.JPA_N1.domain.Subject;
import example.JPA_N1.repository.AcademyRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcademyServiceTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyService academyService;

    @After
    public void cleanAll() {
        academyRepository.deleteAll();
    }

    @BeforeEach
    public void setup() {
        List<Academy> academies = new ArrayList<>();

        for(int i=0; i<10; i++) {
            Academy academy = Academy.builder()
                    .name("강남스쿨" + i)
                    .build();

            academy.addSubject(Subject.builder().name("자바웹개발"+i).build());
            academies.add(academy);
            academyRepository.save(academy);
        }

    }

    @Test
    public void Academy여러개를_조회시_Subject가_N1_쿼리가발생한다() throws Exception {
        // given
        List<String> subjectNames = academyService.findAllSubjectNames();

        // then
        Assertions.assertThat(subjectNames.size()).isEqualTo(10);
    }
}
