package netgloo.System;

import org.springframework.stereotype.Controller;

@Controller
public class Weight {

	public Integer Bulevar = 3;
	public Integer NormalStreet = 1;
	public Integer LinePerDirection = 1;
	public Integer Unpaved = -2;
	public Integer RoughRoad = -1;
	public Integer ExcellentAsphalt = 3;
	//	public Integer ResultWeight = ;

	/**
	 * 
	 * @param streetType - Bulevar or NormalStreet
	 * @param numberOfLines
	 * @param roadQuality - Unpaved or RoughRoad or ExcellentAsphalt
	 */
	public void calculateWeitght(String streetType, Integer LinePerDirection, String roadQuality) {
		Integer ResultWeight = 0;
		switch (streetType) {
		case "Bulevar":  ResultWeight += Bulevar;
		break;
		case "NormalStreet": ResultWeight += NormalStreet;
		break;
		default: ResultWeight += NormalStreet;
		break;
		}

	}

}
