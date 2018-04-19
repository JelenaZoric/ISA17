package isa.projekat.model.dto;

import isa.projekat.model.DateOfPlay;
import isa.projekat.model.Hall;
import isa.projekat.model.Play;
import isa.projekat.model.Theater;

public class Converters {
	
	public static TheaterDTO convertTheaterToTheaterDTO(Theater model) {
		TheaterDTO dto = new TheaterDTO();
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setAddress(model.getAddress());
		dto.setCity(model.getCity());
		dto.setDescription(model.getDescription());
		dto.setTtype(model.getTtype());
		dto.setProgram(model.getProgram());
		return dto;
	}
	
	public static PlayDTO convertPlayToPlayDTO(Play play){
		PlayDTO dto = new PlayDTO();
		dto.setAvgScore(play.getAvgScore());
		dto.setDates(play.getDates());
		dto.setDescription(play.getDescription());
		dto.setDirector(play.getDirector());
		dto.setDuration(play.getDuration());
		dto.setGenre(play.getGenre());
		dto.setId(play.getId());
		dto.setName(play.getName());
		dto.setPrice(play.getPrice());
		dto.setTheater(play.getTheater());
		return dto;
	}
	
	public static DateOfPlayDTO convertDateOfPlayToDateOfPlayDTO(DateOfPlay date){
		DateOfPlayDTO dto = new DateOfPlayDTO();
		dto.setDate(date.getDate());
		dto.setHalls(date.getHalls());
		dto.setId(date.getId());
		dto.setPlay(date.getPlay());
		return dto;
	}
	
	public static HallDTO convertHallToHallDTO(Hall hall){
		HallDTO dto = new HallDTO();
		dto.setDate(hall.getDate());
		dto.setId(hall.getId());
		dto.setName(hall.getName());
		dto.setNumberOfSeats(hall.getNumberOfSeats());
		dto.setSeats(hall.getSeats());
		return dto;
	}

}
