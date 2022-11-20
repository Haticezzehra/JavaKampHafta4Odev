package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

@Service // IOC YE EKLEMESİ İÇİN BUNU YAZIYORUZ.bİR KERE NEWLE Bu snıf bussines
			// nesnesidir
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;// Interfacei kullandık ilerde başka türdde dataAcces ge

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {

		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		// İş kuralları
		return languageRepository.getAll();
	}

	@Override
	public void add(Language language) throws Exception {
		// TODO Auto-generated method stub
		if (language.getName().isEmpty()) {
			throw new Exception("Programlama dili adı bos gecilemez");
		}

		for (Language lang : getAll()) {
			if (lang.getName().equals(language.getName())) {
				throw new Exception("Bu programlama dili zaten var");
			}
		}
		languageRepository.add(language);

	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		for (Language lang : getAll()) {
			if (lang.getId() == id) {
				languageRepository.delete(id);
				break;
			} else {
				throw new Exception("Listede bu programlama dili yok");
			}
		}

	}

	@Override
	public void update(int id, String name) throws Exception {
		// TODO Auto-generated method stub
		for (Language lang : getAll()) {
			if (lang.getId() == id) {
				languageRepository.update(id, name);
				
			} else {
				throw new Exception("Listede bu programlama dili yok.Güncelleme yapılamaz.");
			}
		}

	}

	@Override
	public Language getById(int id) {
		// TODO Auto-generated method stub

		return languageRepository.getById(id);
	}

}
