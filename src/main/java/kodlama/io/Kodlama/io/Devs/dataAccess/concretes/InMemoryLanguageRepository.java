package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@Repository // Bu sınıf data acces nesnesidir.
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;

	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(0, "Java"));
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "Python"));

	}

	@Override
	public List<Language> getAll() {// içinde diler barındıran listeyi döndürücek.
		// TODO Auto-generated method stub
		return languages;
	}

	@Override
	public void add(Language language) {
		// TODO Auto-generated method stub
		languages.add(language);

	}

	@Override
	public void update(int id, String name) {
		// TODO Auto-generated method stub
       Language lang=getById(id);
       lang.setName(name);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		for (Language lang : languages) {
			if (lang.getId() == id) {
				languages.remove(id);
			}
		}

	}

	@Override
	public Language getById(int id) {
		for(Language lang:languages)
		{
			if(lang.getId()==id)
			{
				return lang;
			}
		}
		return null;
	}

}
