interface BuildingRequest {
    id: number,
    type: string,
    status: BuildingStatus,
    coordinate: Coordinate, 
    createdAt: Date,
    startAt: Date,
    endedAT: Date
}

export enum BuildingStatus {
        PENDIENTE,
    EN_PROGRESO,
    TERMINADO
}

export interface Coordinate {
    lat: number,
    lon: number
}


