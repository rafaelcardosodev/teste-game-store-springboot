package br.com.supera.game.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supera.game.store.entities.Client;
import br.com.supera.game.store.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.get();
	}

	public Client insert(Client obj) {
		if (obj.getCreditCard().equals(null) || obj.getCpf().equals(null) || obj.getAddress().equals(null)
				|| obj.getName().equals(null) || obj.getOrders().equals(null)) {
			throw new NullPointerException("All fields must be filled");
		}
		return repository.save(obj);
	}
}
