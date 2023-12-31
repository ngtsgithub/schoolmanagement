package com.ngts.scm.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.ngts.scm.dto.SettingsDTO;
import com.ngts.scm.entity.Settings;
import com.ngts.scm.repository.SettingsRepository;
import com.ngts.scm.vo.SettingsQueryVO;
import com.ngts.scm.vo.SettingsUpdateVO;
import com.ngts.scm.vo.SettingsVO;

@Service
public class SettingsService {

	@Autowired
	private SettingsRepository settingsRepository;

	@Autowired
	private ModelMapper mapper;

	public Integer save(SettingsVO vO) {
		Settings bean = new Settings();
		BeanUtils.copyProperties(vO, bean);
		bean = settingsRepository.save(bean);
		return bean.getSettingsId();
	}

	public void delete(Integer id) {
		settingsRepository.deleteById(id);
	}

	private Settings requireOne(Integer id) {
		return settingsRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
	}

	public void update(Integer id, SettingsUpdateVO vO) {
		Settings bean = requireOne(id);
		BeanUtils.copyProperties(vO, bean);
		settingsRepository.save(bean);
	}

	public SettingsDTO getById(Integer id) {
		Settings original = requireOne(id);
		return toDTO(original);
	}

	private SettingsDTO toDTO(Settings original) {
		SettingsDTO bean = new SettingsDTO();
		BeanUtils.copyProperties(original, bean);
		return bean;
	}

	public Page<SettingsDTO> query(SettingsQueryVO vO) {
		throw new UnsupportedOperationException();
	}

	private SettingsDTO mapToSettingsDTO(Settings settings) {
		return mapper.map(settings, SettingsDTO.class);
	}

	public List<SettingsDTO> getAllSettings() {
		return settingsRepository.findAll().stream().map(this::mapToSettingsDTO).collect(Collectors.toList());
	}

}
